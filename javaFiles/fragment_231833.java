local r = {}

for _, m in pairs(ARGV) do
  r[#r+1] = redis.call('SISMEMBER', KEYS[1], m)
end

return r