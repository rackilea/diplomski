import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {
  transform(items: any[], args: any[]): any[] {
    if (!items) return [];
    return items.filter(it => it[args[0]] == args[1]);
  }
}