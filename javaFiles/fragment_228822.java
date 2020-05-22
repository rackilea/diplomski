Branch branch = new Branch();                          
branch.setName("Foo");
branch.setEnabled(true)                           

ExampleMatcher matcher = ExampleMatcher.matching();        
Example<Branch> example = Example.of(branch, matcher);
branchRepository.findAll(example)