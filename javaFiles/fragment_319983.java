rule "Required skill for a shift"
    when
        Shift(
                employee != null,
                !getEmployee().hasSkills(getSpot().getRequiredSkillSet()))
    then
        scoreHolder.addHardConstraintMatch(kcontext, -100);
end