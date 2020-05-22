if json_resp['status'] == u'OK':
    for pred in json_resp['predictions']:
        desc = pred['description'] 
        if u'Novi Sad' in desc or u'Нови Сад' in desc:
            obj = {
                'name': pred['description'],
                'reference': pred['reference']
            }
            json_result['suggestions'].append(obj)

return json.dumps(json_result)