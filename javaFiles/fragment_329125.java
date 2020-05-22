SELECT
    CASE
      WHEN regexp_instr(messages.NR, '[a-z]{2}[[:space:],_-]\d+[-_]\d{2,6}', 1, 1, 0, 'i') > 0
      THEN regexp_substr(messages.NR, '\d+', 1, 1, 'i')
      ELSE messages.NR
    END AS message_id
...