apply plugin: "java";

def List < String > list = new ArrayList < String > ();

task readFile << {

  new File('jarfile.txt').eachLine {
    line - >
      list.add(line);
  }

}

dependencies() {

  compile files(list);

}

sourceSets {
  main {
    java {
      srcDir 'src';
    }
  }
}

init {
  new File('jarfile.txt').eachLine {
    line - >
      if (!line.equals(""))
        list.add(line);

  }