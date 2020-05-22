class Cage {
    static belongsTo = [zoo: Zoo] // a cage belongs to a single particular Zoo
    Species species // a cage has a single Species
    String name
}

class Zoo {
    static hasMany = [cages: Cage]
    String name
}

class Species {
    static hasMany = [cages: Cage] // a species can be in many different cages
    String name
}

// one way of representing histories
class ResidenceHistory = {
    Species species
    Cage cage
    DateTime from
    DateTime until
}