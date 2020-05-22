package com.dius.bowling;

class DiusBowlingGameTest {

private DiusBowlingGame bowlingGame;

@BeforeEach
void setUp() {
    this.bowlingGame = new DiusBowlingGame();
    this.bowlingGame.startGame();
}