CREATE OR REPLACE VIEW `event_feed_summary_view` AS
  SELECT
    max(feed.trigger_count) * up.amount AS total_amount,
    feed.trigger_count,
    uf.feed_id,
    feed.event_id,
    feed.event_trigger_id,
    up.amount
  FROM event_trigger_feeds feed
    INNER JOIN event_type_triggers trig ON feed.event_trigger_id AND trig.id
    INNER JOIN user_feed uf ON uf.event_id = feed.event_id AND uf.event_trigger_id = feed.event_trigger_id
  GROUP BY uf.feed_id, feed.event_id, feed.event_trigger_id;