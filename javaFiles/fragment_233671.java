class Field{

private String fieldname;
private int fieldnumber;

public Field (String fieldname, int fieldnumber)
{
    this.fieldname = fieldname;
    this.fieldnumber= fieldnumber;
}

public String getFieldname(){
    return fieldname;
}
public int getFieldnumber(){
    return fieldnumber;
}
public String toString(){
    return fieldnumber+ "  " +fieldname;
}
public boolean equals(Object obj){
   Field field = (Field) obj;
    return (fieldnumber == field.fieldnumber && fieldname.equals(field.fieldname);
}
}