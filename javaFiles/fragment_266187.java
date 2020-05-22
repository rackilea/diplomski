// would be a field
private EnumSet<PossibleClasses> commonOption =  EnumSet.of(CLASS_A, CLASS_B);

// somewhere inside code
if (commonOption.contains(PossibleClasses.fromClass(klass))) { 
   // instructions which are common for both classes
}