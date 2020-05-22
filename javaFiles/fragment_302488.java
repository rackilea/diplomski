String[] parts= oneLine.split("\\s*\\|\\s*");
    //System.out.println(parts[0]);
    String tmp=parts[0].substring("start:".length());
    this.begin=Integer.parseInt(tmp);
    String tmp1=parts[1].substring("stop:".length());
    this.end=Integer.parseInt(tmp1);
    String tmp2=parts[2].substring("name:".length());
    this.uri=tmp2;