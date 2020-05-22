//permutation in cycle notation
Permutation p1 = Permutations.createPermutation(new int[][]{{0, 9, 3}, {5, 8, 6}, {7, 11, 12}});
//permutation in one-line notation
Permutation p2 = Permutations.createPermutation(2, 0, 1, 8, 3, 5, 7, 11, 4, 12, 9, 6, 10);
//Construct permutation group
PermutationGroup pg = PermutationGroup.createPermutationGroup(p1, p2);
//this group is transitive
assert pg.isTransitive();
//its order = 5616
System.out.println(pg.order());
//Create alternating group Alt(13)
PermutationGroup alt13 = PermutationGroup.alternatingGroup(13);
//its order = 3113510400
System.out.println(alt13.order());
assert alt13.containsSubgroup(pg);
//Direct product of two groups
PermutationGroup pp = pg.directProduct(PermutationGroup.symmetricGroup(8));
//Setwise stabilizer
PermutationGroup sw = pp.setwiseStabilizer(1, 2, 3, 9, 10, 11, 12, 3, 14, 15, 16, 17, 18);
assert pp.containsSubgroup(sw);
//its order = 17280
System.out.println(sw.order());
//Center of this stabilizer
PermutationGroup center = sw.center();
//it is abelian group
assert center.isAbelian();
//generators of center
//[+{}, +{{19, 20}}, +{{2, 10}, {3, 9}, {6, 8}, {11, 12}}]
System.out.println(center.generators());