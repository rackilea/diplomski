secondField = display.newText( "Touch to Start", 155, 155, native.systemFontBold, 16 )
secondField:setFillColor( 1 )

local function networkListener( event )
      --local alert = native.showAlert( "Corona", "Crap", { "OK"} )
    if ( event.isError ) then
           local alert = native.showAlert( "Corona", event.response, { "OK"} )
    else
    local pattern = ">%d%d,%d%d%d<"
    local buyPrice = string.sub(event.response, string.find(event.response, pattern))
      -- local alert = native.showAlert( "Corona", string.sub(buyPrice, 2, -2), { "OK"} )
      local junkLength = string.len(event.response);
      local sellJunk = string.find(event.response, pattern)
        local  sellPriceJunk= string.sub(event.response, sellJunk+50, sellJunk-junkLength+1000)
        local sellPrice = string.sub(sellPriceJunk, string.find(sellPriceJunk, pattern))
secondField.text = string.sub(buyPrice,2,-2).." and "..string.sub(sellPrice,2,-2)

   local alert = native.showAlert( "Corona", string.sub(buyPrice,2,-2).." and "..string.sub(sellPrice,2,-2), { "OK"} )

end
end

network.request( "https://moneymex.com/Home/Welcome", "GET", networkListener )