f  = {  'name' : 'Incoming packet on $1'  }
hostname = 'somehostname'

itemObj = zapi.item.get(filter=f, host=hostname, output=['itemids', 'name', 'key_'] )

for item in itemObj:
    if re.search('eth0', item['key_']):
        print item['itemid']