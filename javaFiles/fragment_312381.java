POST /sessions/session/1/_update
{
  "scripted_upsert": true,
  "script": {
    "inline": "if (ctx.op == \"create\") ctx._source.numbers = newNumbers; else ctx._source.numbers += updatedNumbers",
    "params": {
      "newNumbers": [1,2,3],
      "updatedNumbers": [55]
    }
  },
  "upsert": {}
}