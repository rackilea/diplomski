{ "$group": {
  "_id": {
    "programa": "$programa",
    "dataHora": {
      "$add": [
        { "$subtract": [
          { "$subtract": [{ "$subtract": ["$dataHora", new Date(0)] }, 25200000 ] },
          { "$mod": [
            { "$subtract": [{ "$subtract": ["$dataHora", new Date(0)] }, 25200000 ] },
            1000 * 60 * 60 * 24
          ]}
        ]},
        new Date(0)
      ]
    }
  },
  "count": { "$sum": 1 },
  "valorTotal": { "$sum": "$custo" },
  "duracaoTotal": { "$sum": "$duracao" },
  "dataHora": { "$first": "$dataHora" }
}}