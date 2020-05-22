ArrayList<Gene> matchingGenes = new ArrayList<>();
for (Gene gene1 : genelist1) {
    for (Gene gene2 : genelist2) {
        if gene1.getName().equals(gene2.getName) {
            matchingGenes.add(gene1);
            matchingGenes.add(gene2);
        }
    }
}