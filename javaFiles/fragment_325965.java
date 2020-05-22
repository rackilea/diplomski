main{

var src = new IloOplModelSource("loads1.mod");
var def = new IloOplModelDefinition(src);


var iteration=1;  

    while(iteration<=796){
        var opl = new IloOplModel(def,cplex);
        var filename="loads1_"+iteration;
        var data = new IloOplDataSource(filename+".dat");
        opl.addDataSource(data);
        var details=opl.dataElements;
        opl.generate();
        if(cplex.solve()){
            writeln(filename+"->"+1);
        }
        else{
            writeln(filename+"->"+0);
        }
        iteration++
    }
}