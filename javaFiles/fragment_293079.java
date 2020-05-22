POST _analyze
{
  "tokenizer": {
    "type": "char_group",
    "tokenize_on_chars": [
      "letter",
      "whitespace"
    ]
  },
  "text": "This is a good thing for versions before 3.2 but bad for 3.5 and later"
}