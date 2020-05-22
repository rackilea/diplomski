data=dp.getData();
int pos = data.length-1;
while (pos != 0 && data[pos] == 0) {
    pos--;
}
s=new String(data, 0, pos);