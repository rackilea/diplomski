String[] list = line.split(cvsSplitBy);
//                System.out.println("the size is " + country[1]);
for (int i = 0; i &lt; list.length; i++) {
    sub.add(list[i]);
}

List<String> temp = (List<String>) ((ArrayList<String>) sub).clone();
//                master.add(new ArrayList<String>(sub));
master.add(temp);
sub.removeAll(sub);