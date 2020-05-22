task export(type: Copy) {
    from project(':subProject1').jar
    from project(':subProject2').jar
    from project(':subProject3').war
    into 'export/'
}