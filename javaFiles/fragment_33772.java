borders: [
  header("\
    <#if pp.outputFile?contains(r'${')>\
      <#assign finalOutputFile>/<@pp.outputFile?interpret /></#assign>\
      <@pp.renameOutputFile name=finalOutputFile />\
    </#if>\
    ", **/*)
]