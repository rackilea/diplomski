List<int> list = ...;
int idElement;
while (rs.next) {
    idElement = rs.getInt("elementId");
    if (list.contains(idElement)) {
       //do this
    }else{
       //do this
    }
}