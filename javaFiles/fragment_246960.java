public void squeezeMe(char[] characters) {
    SqueezeState state = SqueezeState.START;

    int p = 0;
    for (int i = 0; i < characters.length; i++) {
        SqueezeState newState = SqueezeState.START;

        // Evaluate input based on current state
        switch (state) {
        case START:
        case NOT_A_SPACE: {
            if (Character.isWhitespace(characters[i])) {
                newState = SqueezeState.FIRST_SPACE;
            } else {
                newState = SqueezeState.NOT_A_SPACE;
            }
            break;
        }
        case FIRST_SPACE:
        case EXTRA_SPACE: {
            if (Character.isWhitespace(characters[i])) {
                newState = SqueezeState.EXTRA_SPACE;
            } else {
                newState = SqueezeState.NOT_A_SPACE;
            }
        }
        }

        // Transition to new state
        switch (newState) {
        case NOT_A_SPACE:
        case FIRST_SPACE: {
            if (i > p) {
            characters[p] = characters[i];
            }
            p++;
            break;
        }
        }

        state = newState;
    }

    for (int i = p; i < characters.length; i++) {
        characters[i] = '\u0000';
    }

}

private enum SqueezeState {
    START, NOT_A_SPACE, FIRST_SPACE, EXTRA_SPACE;
}

@Test
public void test1() {
    char[] result = { 'a', 't', ' ', '.', ' ', ' ', 'g', ' ', ' ', 'h', ' ' };
    char[] expected = { 'a', 't', ' ', '.', ' ', 'g', ' ', 'h', ' ', '\u0000', '\u0000' };
    squeezeMe(result);
    assertEquals(expected.length, result.length);
    for (int i = 0; i < expected.length; i++) {
        assertEquals("Index " + i, expected[i], result[i]);
    }
}