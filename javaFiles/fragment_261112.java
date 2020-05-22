dependencies{
  compile 'my.group:requiredLibrary:2.0.0'
  compile ('my.group:someDependency:0.1.5'){
      exclude group: 'my.group'  module:'requiredLibrary'
  }
}