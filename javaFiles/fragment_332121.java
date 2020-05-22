if(!(title.equals("")))
{
    if (m.length == count) {
    // expand list
        m = Arrays.copyOf(m, m.length + arrayGrowth);
    }
    m[count] = Native.toString(buffer);
    System.out.println("title====" + m[count]);
    count++;
    inflList.add(new WindowInfo(hWnd, r, title));
}