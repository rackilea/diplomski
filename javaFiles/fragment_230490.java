for(Enumeration<Integer> elements = stack.elements();elements.hasMoreElements();){            
    jTextArea.append(elements.nextElement() + System.lineSeparator());
}
//or    
for(int i = 0; i < stack.size(); i++) {
    jTextArea.append(stack.get(i) + System.lineSeparator());
}
//or    
for (Integer aStack : stack) {
    jTextArea.append(aStack + System.lineSeparator());
}