val diceLevels = Regex("([0-9]+d[0-9]+) at ([0-9]+)")
        .findAll(text)
        .let { levelMatches ->
            levelMatches.associate {
                (it.groupValues[2] to it.groupValues[1])
            }
        }