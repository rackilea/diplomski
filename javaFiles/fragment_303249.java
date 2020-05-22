public void push(E newValue)
{
    E[] newData = (this.size < this.data.length ? this.data : (E[])new Object[this.size * 2]);
    System.arraycopy(this.data, 0, newData, 1, this.size);
    newData[0] = newValue;
    this.data = newData;
    this.size++;
}