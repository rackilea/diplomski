environments {
    production {
        log4j = { root ->
            appenders {
                rollingFile name:'stdout', file:"${logDirectory}/myapp.log".toString(), maxFileSize:'100KB'
                rollingFile name:'stacktrace', file:"${logDirectory}/myapp_stack.log".toString(), maxFileSize:'100KB'
            }
            warn       'org.codehaus.groovy.grails.web.servlet',  //  controllers
                    'org.codehaus.groovy.grails.web.pages', //  GSP
                    'org.codehaus.groovy.grails.web.sitemesh', //  layouts
                    'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                    'org.codehaus.groovy.grails.web.mapping', // URL mapping
                    'org.codehaus.groovy.grails.commons', // core / classloading
                    'org.codehaus.groovy.grails.plugins', // plugins
                    'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
                    'org.springframework',
                    'org.hibernate'
            debug  'com.mypackage'
            root.level = org.apache.log4j.Level.INFO
        }
    }
}