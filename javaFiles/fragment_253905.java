Font f = new Font();
f.setSize(8);

for (Element e : XMLWorkerHelper.parseToElementList(content, null)) {
    for (Chunk c : e.getChunks()) {
        c.setFont(f);
    }
    cell.addElement(e);
}    
    table.addCell(cell); 
}