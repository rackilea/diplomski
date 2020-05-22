@Override
public int compareTo(ItemSales item) {
    if (this.totalSales < item.totalSales) {
        return -1;
    }
    else if(this.totalSales > item.totalSales){
        return 1;
    }

    return 0;
}