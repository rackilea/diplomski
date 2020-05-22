private void formJson(Node node, StringBuilder sb) {
        sb.append("{\"start\": \"");
        sb.append(node.getStart());
        sb.append("\", \"end\": ");
        sb.append(node.getEnd());

        sb.append(", \"children\": [");
        for (Node n: node.getChildrens()){
            if(n.getDone()==1){
                continue;
            }
            formJson(n, sb);
            sb.append(",");
        }
        if (sb.charAt(sb.length()-1)==','){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        sb.append("}");
    }