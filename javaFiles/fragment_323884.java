@Override
public boolean equals(Object other) {
    if (this == other) return true;
    if (other instanceof MyDTO) { 
        MyDTO otherDTO = (MyDTO) other; 
        return this.getValue().equals(otherDTO.getValue()); // mind null values
    } 
    return false; 
}