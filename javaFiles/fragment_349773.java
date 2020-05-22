private List<Row> rows;

/* GETTER AND SETTER */

public String execute(){
    rows = loadRowsInSomeWay();
    return SUCCESS;
}