war {
    webInf {
       from("run_${System.getProperty('user.name')}.properties") {
          rename {
             'run.properties'
          }
       }
    }
}