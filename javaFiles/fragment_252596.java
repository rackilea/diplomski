http = require("http")

core.register_action("handle_redirect", {"http-res"}, function(txn)

  local hdr = txn.http:res_get_headers()
  if hdr["location"] == nil then
    return nil
  end


  local r, msg = http.get{
    url = hdr["location"][0]
  }

  if r == nil then
    return msg
  end

  local res = "HTTP/1.1 " .. r.status_code .. " " .. r.reason .. "\r\n"
  for k, v in pairs(r.headers) do
    res = res .. k .. ": " .. v .. "\r\n"
  end
  res = res .. "\r\n"
  res = res .. r.content


  txn.res:set(res)
  txn.done(txn)

end)