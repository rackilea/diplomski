public class CustomErrorListener : DiagnosticErrorListener
{
    private readonly List<string> _errorMessages = new List<string>();
    public IList<string> ErrorMessages { get { return _errorMessages; } }

    private readonly List<string> _warningMessages = new List<string>();
    public IList<string> WarningMessages { get { return _warningMessages; } }

    public bool HasErrors { get { return _errorMessages.Count > 0; } }
    public bool HasWarnings { get { return _warningMessages.Count > 0; } }

    private readonly bool _captureDiagnostics;

    public CustomErrorListener(bool captureDiagnosticWarnings)
    {
        _captureDiagnostics = captureDiagnosticWarnings;
    }

    public override void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        _errorMessages.Add(string.Format("line {0}:{1} {2} at: {3}", line, charPositionInLine, msg, offendingSymbol.Text));
    }

    public override void ReportAmbiguity(Parser recognizer, Antlr4.Runtime.Dfa.DFA dfa, int startIndex, int stopIndex, bool exact, Sharpen.BitSet ambigAlts, Antlr4.Runtime.Atn.ATNConfigSet configs)
    {
        if (_captureDiagnostics)
        {
            _warningMessages.Add(string.Format("reportAmbiguity d={0}: ambigAlts={1}, input='{2}'", GetDecisionDescription(recognizer, dfa), GetConflictingAlts(ambigAlts, configs), ((ITokenStream)recognizer.InputStream).GetText(Interval.Of(startIndex, stopIndex))));
        }
    }

    public override void ReportAttemptingFullContext(Parser recognizer, Antlr4.Runtime.Dfa.DFA dfa, int startIndex, int stopIndex, Sharpen.BitSet conflictingAlts, Antlr4.Runtime.Atn.SimulatorState conflictState)
    {
        if (_captureDiagnostics)
        {
            _warningMessages.Add(string.Format("reportAttemptingFullContext d={0}, input='{1}'", GetDecisionDescription(recognizer, dfa), ((ITokenStream)recognizer.InputStream).GetText(Interval.Of(startIndex, stopIndex))));
        }
    }

    public override void ReportContextSensitivity(Parser recognizer, Antlr4.Runtime.Dfa.DFA dfa, int startIndex, int stopIndex, int prediction, Antlr4.Runtime.Atn.SimulatorState acceptState)
    {
        if (_captureDiagnostics)
        {
            _warningMessages.Add(string.Format("reportContextSensitivity d={0}, input='{1}'", GetDecisionDescription(recognizer, dfa), ((ITokenStream)recognizer.InputStream).GetText(Interval.Of(startIndex, stopIndex))));
        }
    }
}