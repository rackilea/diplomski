while (temp != null) {
        sb.append(temp.data);
        temp = temp.next;
        if(temp != null)
           sb.append(",");
    }