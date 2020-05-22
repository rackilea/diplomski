@Test
    public void testArchitectureBothWays() {
        ArchitectureUnitState state1 = new ArchitectureUnitState("one","desc one","root");
        ArchitectureUnitState state2 = new ArchitectureUnitState("two","desc two","root");
        ArchitectureUnit unit1 = new ArchitectureUnit("unit1");
        ArchitectureUnit unit2 = new ArchitectureUnit("unit2");
        state1.partOf(state2);
        state2.partOf(state1);
        state1.stateOf(unit1);
        state2.stateOf(unit2);
        architectureUnitStateRepository.save(state1);

        state1 = architectureUnitStateRepository.findByName("one");
        assertEquals("two", state1.getArchitectureUnitState().getName());
        assertEquals("unit1", state1.getArchitectureUnit().getName());


        state2 = architectureUnitStateRepository.findByName("two");
        assertEquals("one",state2.getArchitectureUnitState().getName());
        assertEquals("unit2", state2.getArchitectureUnit().getName());
    }