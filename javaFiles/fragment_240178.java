public class BogOff {



public static void main (String[] args) {
    initAndDrawGraph();
}

public static void initAndDrawGraph() {

    int[] Values = { 25, 50, 100, 125, 150, 175, 200, 225, 250, 275, 300,
            325, 350, 375, 400, 425, 450, 500, 550 };
    /*initialized my array of integers to used as the values of income 
     I will input*/

    TaxChart graph = new TaxChart(Values); //calling my graph
    graph.Initialize();
    graph.Draw();
    graph.PrintTable();
    //my graph uses the 2 methods, Initialize and Draw from TaxChart to 
    //render the graph PrintTable is used to output my income, tax and 
    //income remaining
    }


}