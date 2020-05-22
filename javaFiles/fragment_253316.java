<consolePatternMatchListener
      class="org.eclipse.jdt.internal.debug.ui.console.JavaConsoleTracker"
      regex="\(\w*${java_extensions_regex}\S*\)"
      qualifier="${java_extensions_regex}"
      id="org.eclipse.jdt.debug.ui.JavaConsoleTracker">
   <enablement>
      <or>
        <test property="org.eclipse.ui.console.consoleTypeTest" value="javaStackTraceConsole"/>
        <test property="org.eclipse.debug.ui.processTypeTest" value="java"/>
        <test property="org.eclipse.debug.ui.processTypeTest" value="org.eclipse.ant.ui.antProcess"/>
      </or>
   </enablement>
</consolePatternMatchListener>