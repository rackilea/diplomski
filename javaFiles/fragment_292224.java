HashSet<Ability> abilities = bob.getAbilities();
for (Ability ability : abilities) {
    ActorAbility abilityClass = ability.getAbility();
    if (abilityClass.isTickable()) {
        abilityClass.act(bob);
    }
}