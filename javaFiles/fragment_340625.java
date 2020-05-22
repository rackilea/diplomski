ct = arr.getCategory(i);
KMTCategory kmtcat = new KMTCategory();
kmtcat.ID = ct.getCategoryID();
kmtcat.leafCategory = null == ct.isLeafCategory() || ct.isLeafCategory(); // temporary error fix 
// other values 
KMTgcResponse.categories[i] = kmtcat;  // set the array