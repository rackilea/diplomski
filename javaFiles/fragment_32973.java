while(!(s = in.readUTF()).equals(null))
    {
        ID = in.readUTF();
        System.out.print(ID + " ");
        Name = in.readUTF();
        System.out.println(Name);
    }