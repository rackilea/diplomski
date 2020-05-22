CREATE TABLE TWord (
    wordId INT AUTO_INCR,
    wordText VARCHAR(80),
    INDEX(wordText),
    PRIMARY KEY(wordId)
);
CREATE TABLE TSynonym (
    wordFk INT NOT NULL,
    synonymFk INT NOT NULL,
    CONSTRAINT FOREIGN KEY (wordFk) REFERENCES TWord(wordId),
    CONSTRAINT FOREIGN KEY (synonymFk) REFERENCES TWord(wordId),
    PRIMARY KEY(wordFk, synonymFk)
);