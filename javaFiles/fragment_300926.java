package com.answer.stack.overflow.questionnaire;

public class Answer {
    private String code;
    private String text;

    public Answer(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return code + ": " + text;
    }
}