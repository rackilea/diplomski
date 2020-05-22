public int count;
public int page;
public int last_page;
public int total;
public ArrayList<MyObject> myObjects = new ArrayList();

public int getCount() {
    return count;
}

public void setCount(int count) {
    this.count = count;
}

public int getPage() {
    return page;
}

public void setPage(int page) {
    this.page = page;
}

public int getLast_page() {
    return last_page;
}

public void setLast_page(int last_page) {
    this.last_page = last_page;
}

public int getTotal() {
    return total;
}

public void setTotal(int total) {
    this.total = total;
}

public MyObject getObject(int pos){
    return myObjects.get(pos);
}
public void addObject(MyObject object)
{
    myObjects.add(object);
}
}