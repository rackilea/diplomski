import com.opensymphony.module.sitemesh.parser.HTMLPageParser;

public CustomPageParser extends HTMLPageParser {

    protected void addUserDefinedRules(State html, PageBuilder page) {
        super.addUserDefinedRules(html, page);

        html.addRule(new ScriptExtractingRule(page));
    }

}