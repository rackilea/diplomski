class MyLowLevelClass implements MyUsefulAbstraction { ... }

class MyHighLevelClass {

    MyUsefulAbstraction dep;

    MyHighLevelClass( MyUsefulAbstraction dep ) {
        this.dep = dep;
    }
}

class App {
     void main() {  new HighLevelClass( new LowLevelClass() ).doStuff(); }
 }