@JsonCreator
public PojoVariant(Object[] params) {
    this.chr = (String) params[0];
    this.pos = (int) params[1];
    this.id = (String) params[2];
    this.ref = (String) params[3];
    this.alt = (String) params[4];
    this.quality = (int) params[5];
    this.filter = (String) params[6];
    this.type = (String) params[7];
    this.genotype = (String) params[8];
    this.alignPos = (int) params[9]; 
    this.basePos = (int) params[10];
    this.signalPos = (int) params[11];
}