<suite name="Emap test suite">
<test name="Emap tests">
    <method-selectors>
        <method-selector>
            <script language="beanshell"><![CDATA[        
            addClassPath("target/test-classes" );      
            return com.yourpackage.shouldExecuteTest(groups, System.getProperty("groups"));         
            ]]>